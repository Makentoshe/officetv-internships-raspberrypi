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
        // 0124 0143 q0 a1 b2 f3 d4
        // 0123 0134 q0 a1 b2 d3 f4
        val articleAuthors = ArticleAuthors(ArrayList(listOf("qabd", "qadf")))
        assertEquals("qabfd".toList(), articleAuthors.findLexOrder())
    }

    @Test
    fun test2() {
        val articleAuthors = ArticleAuthors(ArrayList(listOf("qabc", "qbcd", "qadc")))
        assertEquals(null, articleAuthors.findLexOrder())
    }

    @Test
    fun test3() {
        val articleAuthors = ArticleAuthors(ArrayList(listOf("qa","qaqbd", "qaqc", "qaqd", "qbbda", "ab", "ac")))
        assertEquals("qabcd".toList(), articleAuthors.findLexOrder())
    }

    @Test
    fun test4() {
        // proof for q=0, c=1 ...: 02 < 30 < 41 < 53 < 6*
        val articleAuthors = ArticleAuthors(ArrayList(listOf("qa", "eq", "bc", "de", "f")))
        assertEquals("qcaebdf".toList(), articleAuthors.findLexOrder())
    }

    @Test
    fun test5() {
        // q a b f c d e
        // 0 1 2 3 4 5 6
        // qabc   dqaf   efcdq
        // 0124 < 5013 < 63450
        val articleAuthors = ArticleAuthors(ArrayList(listOf("qabc", "dqaf", "efcdq")))
        assertEquals("qabfcde".toList(), articleAuthors.findLexOrder())
    }


}