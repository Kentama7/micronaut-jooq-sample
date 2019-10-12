package micronaut.jooq.sample

import io.micronaut.runtime.Micronaut

object Application {

    @JvmStatic
    fun main(args: Array<String>) {
        Micronaut.build()
                .packages("micronaut.jooq.sample")
                .mainClass(Application.javaClass)
                .start()
    }
}