var gameSquares = [];
var firstSquare = null;
var solved = 0;
var step = 0;
var score = 0;
var startTime = new Date().getTime();
var currentTime;

//function createWinImg(){
//	var img = document.createElement("IMG");
//	var game = document.getElementsByClassName("game");
//    img.setAttribute("src", "/images/concentration/win.png");
//    img.setAttribute("width", "420");
//    img.setAttribute("height", "420");
//    img.setAttribute("alt", "You win!");
//    img.setAttribute("position", "absolute");
//    game.append(img);
//}

var pictures = [];
for (var i = 0; i < 10; i++) {
	pictures.push('square-' + i);
}

function GameSquare(el, picture) {
	this.el = el;
	this.isOpen = false;
	this.isLocked = false;
	this.el.addEventListener("click", this, false);
	this.setPicture(picture);
}

function post() {
	var settings = {
			  "async": true,
			  "crossDomain": true,
			  "url": "http://localhost:8080/rest/scores",
			  "method": "POST",
			  "headers": {
			    "Content-Type": "application/json",
			    "Cache-Control": "no-cache",
			    "Postman-Token": "8bce9cc4-4f6b-4714-af34-8f01a7aacf6d"
			  },
			  "processData": false,
			  "data": `{
			  "player": "admin",
			  "points": ${score},
			  "game": "concentration",
			  "playedOn": ${currentTime-startTime}
			  }`
			}

			$.ajax(settings).done(function (response) {
			  console.log(response);
			});
}

function get(){
	var settings = {
			  "async": true,
			  "crossDomain": true,
			  "url": "http://localhost:8080/rest/scores/concentration",
			  "method": "GET",
			  "headers": {
			    "Cache-Control": "no-cache",
			    "Postman-Token": "d7cd1a51-6016-4aab-8dba-b1391be10463"
			  }
			}

			$.ajax(settings).done(function (response) {
				var getScore = response;
				console.log(response);
				for(let i = 0; i < getScore.length; i++){
					$(".scoreTable").append(i+1 + ". ");
					$(".scoreTable").append(getScore[i].player);
					$(".scoreTable").append(": ");
					$(".scoreTable").append(getScore[i].points);
					$(".scoreTable").append("<br/>");
				}
			});
}

get();

function checkGame(gameSquare) {
	  if (firstSquare === null) {
	    firstSquare = gameSquare;
	    return
	  }
	  
	  step++;
	  currentTime = new Date().getTime();
	  var points = (currentTime-startTime)/step;
	  score = score+points;
	  var fixedScore = score.toFixed(0);
	  
	  $(".score").text(fixedScore);
	  $(".step").text(step+1);

	  if (firstSquare.picture === gameSquare.picture) {
	    firstSquare.lock();
	    gameSquare.lock();
	    solved++;
	  } else {
	    var a = firstSquare;
	    var b = gameSquare;
	    setTimeout(function() {
	      a.reset();
	      b.reset();
	      firstSquare = null;
	    }, 400);
	  }
	  
	  if(solved == 8){
			$(".stepNumber").text("in " + step + " moves");
			$(".step").text("");
			alert("You win");
			$(".scoreTable").text("");
			post();
			get();
		} 
	  
	  firstSquare = null;
	}

GameSquare.prototype.handleEvent = function(e) {
	  switch (e.type) {
	    case "click":
	      if (this.isOpen || this.isLocked) {
	        return;
	      }
	      this.isOpen = true;
	      this.el.classList.add('flip');
	      checkGame(this);
	  }
	}

GameSquare.prototype.reset = function() {
	this.isOpen = false;
	this.isLocked = false;
	this.el.classList.remove('flip');
}

GameSquare.prototype.lock = function() {
	this.isLocked = true;
	this.isOpen = true;
}

GameSquare.prototype.setPicture = function(picture) {
	this.el.children[0].children[1].classList.remove(this.picture);
	this.picture = picture;
	this.el.children[0].children[1].classList.add(picture);
}

function random(n) {
	return Math.floor(Math.random() * n);
}

function getSomePictures() {
	var picturescopy = pictures.slice();
	var randomPictures = [];
	for (var i = 0; i < 8; i++) {
		var index = random(picturescopy.length);
		randomPictures.push(picturescopy.splice(index, 1)[0]);
	}
	return randomPictures.concat(randomPictures.slice());
}

function setupGame() {
	  var array = document.getElementsByClassName("tile");
	  var randomPictures = getSomePictures();             // Get an array of 8
														// random picture pairs
	  for (var i = 0; i < array.length; i++) {  
	    var index = random(randomPictures.length);      // Get a random index
	    var picture = randomPictures.splice(index, 1)[0]; // Get the picture at that
														// index
	    // Use that picture to initialize the GameSquare
	    gameSquares.push(new GameSquare(array[i], picture));
	  }
	}

function randomizePictures() {
	  var randomPictures = getSomePictures();
	  gameSquares.forEach(function(gameSquare) {
	    var picture = randomPictures.splice(random(randomPictures.length), 1)[0];
	    gameSquare.setPicture(picture);
	  });
	}

function clearGame() {
	solved = 0;
	step = 0;
	score = 0;
	startTime = new Date().getTime();
	$(".score").text(score);
	$(".stepNumber").text("Move number:");
	$(".step").text(step+1);
	  gameSquares.forEach(function(gameSquare) {
	    gameSquare.reset();
	  });
	  setTimeout(function() {
	    randomizePictures();
	  }, 500);
	}

setupGame();

 $("#button-restart").click(
 function(){
 clearGame();
 });
 
 
 
 


