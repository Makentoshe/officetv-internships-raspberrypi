import java.lang.IllegalStateException
import java.util.regex.Pattern
import java.util.regex.PatternSyntaxException
import kotlin.concurrent.thread

/**
 * Variant 1 - precompile and coroutine
 *
 * regex - we use Pattern to avoid compilation in the function,
 * because if it will be called in the cycle - the pattern will be compiled each time
 *
 * Best to call in a cycle in the coroutine scope
 */
suspend fun matches1(text: String, regex: Pattern): Boolean {
    return regex.matcher(text).lookingAt()
}

/**
 * Variant 2 - precompile and thread
 *
 * regex - we use Pattern to avoid compilation in the function,
 * because if it will be called in the cycle - the pattern will be compiled each time
 *
 * Doesn't better than variant 1 because each call a new thread will be started, but does not requires coroutines.
 * Mb we can use a thread pool.
 */
fun matches2(text: String, regex: Pattern, callback: (Boolean) -> Unit) = thread(isDaemon = true) {
    callback(regex.matcher(text).lookingAt())
}

/**
 * Variant 3 - thread
 */
fun matches3(text: String, regex: String, callback: (Boolean) -> Unit) = thread(isDaemon = true) {
    try {
        callback(Pattern.compile(regex).matcher(text).lookingAt())
    } catch (pse: PatternSyntaxException) {
        callback(false)
    } catch (iae: IllegalArgumentException) {
        callback(false)
    }
}