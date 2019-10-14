package micronaut.jooq.sample

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.spring.tx.annotation.Transactional
import org.jooq.DSLContext



@Controller
open class SampleCotnroller(
    private val dSLContext: DSLContext
) {
    @Get("/")
    @Transactional
    open fun get(): String {
        println(dSLContext)
        val execute = dSLContext.select().from("author").execute()
        dSLContext.delete(dSLContext.meta().getTables("author")[0]).execute()
        dSLContext.insertInto(dSLContext.meta().getTables("author")[0]).values(6, "1", "2").execute()
//        dSLContext.insertInto(dSLContext.meta().getTables("author")[0]).values(6, "1", "2").execute()
        println(execute)
        return "aaa"
    }
}
