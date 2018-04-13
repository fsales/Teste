package calculadora

import java.text.NumberFormat

class Soma(val expressao1: Expressao? = null, val  expressao2: Expressao? = null) : Expressao {

    override fun calcula(): Double = expressao1?.calcula()!!.plus(expressao2!!.calcula())

}

enum class Operacao(val operador: String) : Expressao {
    Soma("+") {
        override fun calcula(): Double {
            return Soma().calcula() //To change body of created functions use File | Settings | File Templates.
        }


    }
    /*Subtracao("-") {
        override fun calculo(): ExpressaoBase = object : ExpressaoBase() {
            override fun calcula(): Double = expressao1?.calcula()!!.minus(expressao2!!.calcula())
        }
    },
    Multiplicacao(operador = "X") {
        override fun calculo(): ExpressaoBase = object : ExpressaoBase() {
            override fun calcula(): Double = expressao1?.calcula()!!.times(expressao2!!.calcula())
        }
    },
    Divisao("/") {
        override fun calculo(): ExpressaoBase = object : ExpressaoBase() {
            override fun calcula(): Double = expressao1?.calcula()!!.div(expressao2!!.calcula())

        }
    }, Porcentagem(operador = "%"){
        override fun calculo(): ExpressaoBase = object : ExpressaoBase() {
            override fun calcula(): Double {
                return expressao1?.calcula()!!.times(expressao2!!.calcula().div(100))
            }
        }
    }*/;


    //abstract fun calculo(): Expressao

    companion object {
        fun from(findValue: String): Operacao? {

            val single = Operacao.values().singleOrNull({ ope -> ope.operador == findValue })
            return single
        }
    }
}