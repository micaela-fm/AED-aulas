package chapter3

/**
 * This function removes all spaces from a given string.
 *
 * It iterates over each character in the string, and if the character is not a space,
 * it appends it to a new string. The new string, which does not contain any spaces, is then returned.
 *
 * @param str The original string from which spaces are to be removed.
 * @return The new string without any spaces.
 *
 * Time complexity - O(n), where n is the length of the string.
 * Space complexity - O(n), where n is the length of the string.
 */
fun eliminaEspacos(str: String): String {
    val n = str.length
    var nova = ""

    for (i in 0 until n) {
        if (str[i] != ' ') {
            nova = nova + str[i]
        }
    }
    return nova
}