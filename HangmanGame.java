import java.util.ArrayList;
import java.util.Collections;

class HangmanGame {
    private String word = randomWord(); // Assigns random word
    private char[] letters = word.toCharArray(); // Splits word to array of chars
    public int wordLength = word.length(); // Length of word
    public int lives = 4; // # Of lives
    private char[] progress; // Char array of current progress
    public boolean gameOver = false; // boolean of if game is over
    public ArrayList<Character> guessed = new ArrayList<Character>(); // Character Array List of guessed letters

    // Gets random word from list
    public String randomWord() {
        String[] arr = "abolish abridge abstract acclaim accommodate accord adamant advent adversary adversity aesthetic affiliation affirmation affliction aftermath aggravation ambidextrous ambiguous anecdote anguish animated annihilate anonymous apprehensive apprentice aptitude arbitrary arid artifact aspiration assent assertive audacious augment auxiliary avert belligerent benevolent benign bestow bewilder boisterous breach brevity calligraphy cavernous chaotic charisma choreography chronicle chronological circumstantial clientele coalition coerce collaborate collateral colossal commandeer commemorate communal competent concede concentric concise concurrent condemnation condole conglomerate conjecture conscientious consensus constrain contemplate contemporary contrary convene conventional convergent cordial cornucopia credible cynical decipher deficit denounce deprivation derivative designation desolate despicable deterrent deviate dilemma dire discern discrepancy disentangle dismantle dispel disposition dissension distortion divergent diversion dominion dormant dreary dubious eccentric eclipse ecstatic egotistical eloquent embark emphatic encompass eradicate erratic excise exclusion excruciating excursion exemplify expansive facilitate fanaticism fidelity flaunt fluctuate formative formulate fortification fossilized frivolous fruitless futile generic genre gingerly gratification gullible harmonious havoc hindrance homage homogeneous hypocritical hypothetical illustrious impediment impending impenetrable imperative implicit imposition impoverished improvise impulsive inanimate inaugural incarcerate incompatible inconceivable inconclusive inconsequential indispensable induce ineffectual inference infiltrate ingenuity ingrained inherent inhibit initiate innovation instigate integral interim intricate introvert irrelevant jargon jeopardy judicious kinetic laborious lattice lavish longevity luminous luxuriant malice malignant mediocre melancholy memorandum metaphor metropolitan moderation monotonous monumental morale naive nocturnal norm notorious novice nurture objective obliterate ominous omnipotent omniscient parable paradox paramount paraphrase patronize perennial perilous periphery pervasive piety placid plight porous posterity potency preamble predecessor predicament predominant procrastinate procure prophetic protocol proximity purge quarantine ransack ratification rationale ravage ravenous rectify referendum refrain refurbish regime rehabilitate reimburse relinquish reminiscent remnant renovate repercussion replenish repulsive requisite resolve retaliate retort reversion rhetoric rubble rustic sabotage saga sanction satire seasoned secular sedentary senile serene sinister skeptic sovereign spatial squander stagnant stature statutory stereotype strife stupendous subdue subterranean subtle subversive succumb superficial superlative supplement surge susceptible synthesis temperance tenacious tentative terrestrial torrential tranquil traverse trifle trivial turmoil unanimous undermine unison unprecedented unquenchable unrestrained unsightly unsurpassed vengeful versatile viable vibrant vicious vile vintage vogue wary wholesome"
                .split(" ");

        int wordIndex = (int) (arr.length * Math.random());
        return arr[wordIndex];
    }

    // Sets up hangman game
    HangmanGame(String playing) {
        if (playing.equals("1") != true) {
            word = playing;
            letters = word.toCharArray(); // Splits word to array of chars
            wordLength = word.length(); // Length of word
        }
        progress = createBlanks();
        System.out.println("Guess a letter the word is " + wordLength + " characters long.");
        System.out.println("You have " + lives + " lives left.");
        visual();
        display();
        System.out.print("Guess: ");
    }

    // Creates char array of blanks the length of word
    public char[] createBlanks() {
        char[] blanks = new char[word.length()];
        for (int i = 0; word.length() > i; i++) {
            blanks[i] = '_';
        }
        return blanks;
    }

    // Prints progress
    public void display() {
        for (int i = 0; word.length() > i; i++) {
            System.out.print(progress[i]);
            System.out.print(' ');
        }
        System.out.println(' ');
    }

    // Check input
    public void check(String gLetter) {
        // Check if letter
        if (Character.isLetter(gLetter.charAt(0)) == false) {
            System.out.println("Please guess a letter.");
            System.out.print("Guess:");
            return;
        }
        // Check if letter is part of the word
        boolean notDone = true;
        for (int i = 0; word.length() > i; i++) {
            if (gLetter.charAt(0) == letters[i]) {
                progress[i] = gLetter.charAt(0);
                notDone = false;
            }
        }
        // Check if game over
        if (notDone) {
            lives -= 1;
            System.out.println("Sorry " + gLetter.charAt(0) + " is not part of the word.");
        }
        guessAgain();
    }

    // Check amount of remaining blanks
    public int checkBlanks() {
        int blanksLeft = 0;
        for (int i = 0; word.length() > i; i++) {
            if ('_' == progress[i]) {
                blanksLeft += 1;
            }
        }
        return blanksLeft;
    }

    // Check why/if game over
    public void complete() {
        if (lives == 0) {
            System.out.println("Game over you suck.");
            System.out.println("The correct word was '" + word + "' how did you not guess that.");
            gameOver = true;
        } else if (checkBlanks() == 0) {
            System.out.println("You guessed the word!");
            System.out.println("Nice win.");
            gameOver = true;
        }
    }

    // Display hangman visuals
    public void visual() {
        System.out.println("   ____");
        System.out.println("  |    |");
        if (lives <= 3) {
            System.out.println("  |    o");
        } else {
            System.out.println("  |");
        }
        if (lives <= 2) {
            System.out.println("  |   /|\\");
        } else if (lives <= 2) {
            System.out.println("  |    |");
        } else {
            System.out.println("  |");
        }
        if (lives <= 1) {
            System.out.println("  |    |");
        } else {
            System.out.println("  |");
        }
        if (lives <= 0) {
            System.out.println("  |   / \\");
        } else {
            System.out.println("  |");
        }
        System.out.println(" _|_");
        System.out.println("|   |______");
        System.out.println("|          |");
        System.out.println("|__________|");
    }

    // Check if letter already guessed & if word
    public void isGuessed(String g) {
        // Check if word
        if (g.equals(word)) {
            System.out.println("You guessed the word!");
            System.out.println("Nice win.");
            gameOver = true;
            return;
        }
        // Check if guessed
        if (guessed.contains(g.charAt(0))) {
            System.out.println("You're an idiot! You have already guessed that guess something else stupid.");
            System.out.print("You have guessed: ");
            Collections.sort(guessed);
            for (Character guesses : guessed) {
                System.out.print(guesses + " ");
            }
            System.out.println();
            System.out.print("Guess:");
        } else {
            guessed.add(g.charAt(0));
            check(g);
        }
    }

    // Sets up guess again info
    public void guessAgain() {
        visual();
        display();
        System.out.println("Guess again.");
        System.out.println("You have " + lives + " lives left.");
        if ((checkBlanks() != 0) && (lives != 0)) {
            System.out.print("Guess: ");
        }
    }
}