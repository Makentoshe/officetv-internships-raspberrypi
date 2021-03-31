import java.util.*
import kotlin.collections.ArrayList

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val limit = scanner.nextInt()
    val names = (0 until limit).map { scanner.next() }

    val articleAuthors = ArticleAuthors(ArrayList(names))
    println(articleAuthors.findLexOrder() ?: return println("Impossible"))
}

class ArticleAuthors(val authors: ArrayList<String>) {

    fun findLexOrder(): List<Char>? {
        val alphabet = LinkedList<Char>()
        // create initial alphabet
        authors.map { it.first() }.toSet().forEach(alphabet::addLast)
        // try to "greedy" naive algorithm
        authors.forEachIndexed { aindex, author ->
            author.forEachIndexed { cindex, char ->
                if (!alphabet.contains(char)) {
                    alphabet.addOrLast(cindex, char)
                }
            }
        }
        // check the result
        val unsorted = authors.map { author -> author.map(alphabet::indexOf).joinToString("") }
        val sorted = unsorted.sorted()
        return if (!sorted.equals(unsorted)) null else alphabet
    }

    private fun <E> LinkedList<E>.addOrLast(index: Int, element: E) {
        if (size <= index) addLast(element) else add(index, element)
    }
}
