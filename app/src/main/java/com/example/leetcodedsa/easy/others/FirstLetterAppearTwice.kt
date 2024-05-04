package com.example.leetcodedsa.easy.others

/*
fun main() {
    val fl = FirstLetterAppearTwice()
    fl.repeatedCharacterTwo("abcdefghabijklmn")
}
*/

// Question 2651
class FirstLetterAppearTwice {

    /**
     * Best Answer
     * Using Map is not efficient when compared to Arrays
     */
    fun repeatedCharacter(s: String): Char {
        val arr = arrayListOf<Char>()
        for (str in s) {
            if (arr.contains(str)) {
                return str
            } else arr.add(str)
        }
        return 'n'
    }

    fun repeatedCharacterTwo(s: String): Char {
        val mapping: MutableMap<Char, Int> = mutableMapOf()
        s.forEach { char ->
            println(mapping)
            if (mapping[char] != null){
                return char
            } else mapping[char] = 1
        }
        return 'n'
    }
}