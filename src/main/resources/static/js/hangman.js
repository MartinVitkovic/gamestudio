//region VARIABLES
var counter = 0;
var secretWordsArray = [ "javascript", "apple", "Silvia", "game", "school",
		"sql", "official video" ];
var secret = secretWordsArray[Math.floor(Math.random()
		* secretWordsArray.length)];
secret = secret.toUpperCase();
var guessedLetters = "";
// endregion

function changePicture() {
	$("#hang").attr("src", "/images/hangman/phase" + counter + ".png");
}

function getGuessedWord(secret, lettersGuessed) {
	var word = "";
	for (var i = 0; i < secret.length; i++) {
		if (lettersGuessed.includes(secret.charAt(i))
				|| secret.charAt(i).includes(" ")) {
			word += secret.charAt(i);
			word += " ";
		} else {
			word += "_ ";
		}
	}
	return word;
}

$("#button-restart").click(
		function() {
			$("#hang").attr("src", "/images/hangman/phase0.png");
			guessedLetters = "";
			secret = secretWordsArray[Math.floor(Math.random()
					* secretWordsArray.length)];
			secret = secret.toUpperCase();
			$("#span-char").text(getGuessedWord(secret, guessedLetters));
			$(".button-char").removeAttr('disabled');
			$(".button-char").show();
			counter = 0;
		});

$(".button-char").click(function() {
	if (!secret.includes($(this).text())) {
		guessedLetters += $(this).text();
		counter += 1;
		changePicture();
		$(this).hide();
		if (counter >= 5) {
			$(".button-char").attr('disabled', 'disabled');
			$("#hang").attr("src", "/images/hangman/gameover.png");
		}
	} else {
		guessedLetters += $(this).text();
		$(this).hide();
		$("#span-char").text(getGuessedWord(secret, guessedLetters));
		if (!($("#span-char").text().includes("_"))) {
			$(".button-char").attr('disabled', 'disabled');
			$("#hang").attr("src", "/images/hangman/welldone.jpg");
		}
	}
});

$(function() {
	$("#span-char").text(getGuessedWord(secret, guessedLetters));
});
