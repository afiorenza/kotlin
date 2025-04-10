package courses.hangman

var words = listOf(
    "raton",
    "lapiz",
    "tren",
    "nube",
    "flor",
    "fuego",
    "calle",
    "torre",
    "canto",
    "bolso",
    "queso",
    "reloj",
    "gato",
    "salto",
    "avion",
    "hielo"
)

var maximumIntents = 6

fun readLetterAndCompare(letters: HashSet<Char>): Char {
    var letter = ""

    do {
        println("Enter next letter:")

        letter = readln() ?: ""

        val correctLength = letter.length == 1
        val alreadyEntered = letters.contains(letter.getOrNull(0))

        if (!correctLength) println("You have to enter just one letter.")
        if (alreadyEntered) println("$letter has already been entered.")

    } while (!correctLength || alreadyEntered)

    return letter[0]
}

fun printWord(word: String) {
    println("The word is $word")
}

fun main(args: Array<String>) {
    var word = words.random()
    var intent = 0

    val letters = hashSetOf<Char>()

    var guessedWorld = "";

    printWord(word.map { "_" }.joinToString(""))

    do {
        var letter = readLetterAndCompare(letters)

        letters.add(letter)

        guessedWorld = word.map {
            if (letters.contains(it)) it else "_"
        }.joinToString("")

        if (!guessedWorld.contains(letter)) {
            println("Wrong intent!")

            intent++
        }

        printWord(guessedWorld)
    } while (guessedWorld != word && intent < maximumIntents)

    if (guessedWorld == word) {
        println("Hurrayyy, the world was $guessedWorld")
    } else {
        println("You are a looser");
    }
}