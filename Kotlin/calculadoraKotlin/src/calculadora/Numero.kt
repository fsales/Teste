package calculadora

class Numero(val numero: Double?) : Expressao {

    override fun calcula() = numero

}