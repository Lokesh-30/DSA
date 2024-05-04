package com.example.leetcodedsa.easy.others

/*
fun main() {
    val cp = CheckSentencePangram()
    val res = cp.checkIfPangram("thequickbrownfoxjumpsoverthelazydog")
    println(res)
}
*/

// Question 1832
// Best Answer
class CheckSentencePangram {
    fun checkIfPangram(sentence: String): Boolean {
        return sentence.toSet().size == 26
    }
}