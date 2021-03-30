import org.junit.Assert.assertEquals
import org.junit.Test

class ArticleAuthorTest {

    @Test
    fun test0() {
        val articleAuthors = ArticleAuthors(ArrayList(listOf("qabc", "qacc")))
        assertEquals("qabc".toList(), articleAuthors.findLexOrder())
    }

    @Test
    fun test1() {
        val articleAuthors = ArticleAuthors(ArrayList(listOf("qadf", "qabd")))
        assertEquals("qabdf".toList(), articleAuthors.findLexOrder())
    }

    @Test
    fun test2() {
        // q a b c d e ... x y z
        // Impossible
        val articleAuthors = ArticleAuthors(ArrayList(listOf("qabc", "qbcd", "qadc")))
    }

    @Test
    fun test3() {
        val articleAuthors = ArticleAuthors(ArrayList(listOf("qa","bc", "de", "f")))
        assertEquals("qabcdef".toList(), articleAuthors.findLexOrder())
    }

    @Test
    fun test4() {
        val articleAuthors = ArticleAuthors(ArrayList(listOf("qaqbd", "qaqc", "qaqd", "qa", "qbbda", "ab", "ac")))
        assertEquals("qabcd".toList(), articleAuthors.findLexOrder())
    }


}