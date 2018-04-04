package calculadora

internal class Subtracao(expressao1: Expressao, expressao2: Expressao) : ExpressaoBase(expressao1, expressao2) {
    override fun calcula(): Double? =
            expressao1.calcula()?.minus(expressao2.calcula()!!)
}

internal class Soma(expressao1: Expressao, expressao2: Expressao) : ExpressaoBase(expressao1, expressao2) {
    override fun calcula(): Double? =
            expressao1.calcula()?.plus(expressao2.calcula()!!)
}

internal class Multiplicacao(expressao1: Expressao, expressao2: Expressao) : ExpressaoBase(expressao1, expressao2) {
    override fun calcula(): Double? =
            expressao1.calcula()?.times(expressao2.calcula()!!)
}

internal class Divisao(expressao1: Expressao, expressao2: Expressao) : ExpressaoBase(expressao1, expressao2) {
    override fun calcula(): Double? =
            expressao1.calcula()?.div(expressao2.calcula()!!)
}


enum class Operacao(val operador: String) {
    Soma("+") {
        override fun calculo(expressao1: Expressao, expressao2: Expressao): Expressao = Soma(expressao1, expressao2)
    },
    Subtracao("-") {
        override fun calculo(expressao1: Expressao, expressao2: Expressao): Expressao = Subtracao(expressao1, expressao2)
    },
    Multiplicacao("*") {
        override fun calculo(expressao1: Expressao, expressao2: Expressao): Expressao = Multiplicacao(expressao1, expressao2)
    },
    Divisao("/") {
        override fun calculo(expressao1: Expressao, expressao2: Expressao): Expressao = Divisao(expressao1, expressao2)
    }
    ;

    abstract fun calculo(expressao1: Expressao, expressao2: Expressao): Expressao

    companion object {
        fun from(findValue: String): Operacao? {

            val single = Operacao.values().singleOrNull({ ope -> ope.operador == findValue })
            return single
        }
    }
}

fun main(args: Array<String>) {
    val aa = Operacao.from("5")
    print(aa?.operador)
}