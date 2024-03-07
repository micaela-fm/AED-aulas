package dia.aula5

fun eliminaEspacos(str: String): String {
    val n = str.length
    var nova = ""

    for (i in 0..< n) {
        if (str[i] != ' ') {
            nova = nova + str[i]
        }
    }
    return nova
}

