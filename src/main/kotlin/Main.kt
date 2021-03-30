import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap
import kotlin.collections.HashSet

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val limit = scanner.nextInt()
    val names = (0 until limit).map { scanner.next() }

    val articleAuthors = ArticleAuthors(ArrayList(names))
}

class ArticleAuthors(
    val authors: ArrayList<String>
) {

    private val alphabet = LinkedList<Char>()

    fun findLexOrder(): List<Char> {
        authors.forEach { author ->
            author.forEachIndexed { index, char ->
                if (!alphabet.contains(char)) {
                    alphabet.addOrLast(index, char)
                }
            }
        }
        return alphabet
    }

    private fun <E> LinkedList<E>.addOrLast(index: Int, element: E) {
        if (size <= index) addLast(element) else add(index, element)
    }
}
