import calculadora.*

fun main(args: Array<String>) {

    //val lista = mutableListOf<String>("5", "+", "2","+","5","/","2","X","2","-","1","2")
    val lista = mutableListOf<String>("5", "/", "10")
    var list = mutableListOf<Any>()

    for (t in lista) {

        val op = Operacao.from(t)

        if (op == null) {
            if (t.toDoubleOrNull() != null) list.add(Numero(t.toDouble()))
        } else {
            list.add(op)
        }
    }

    val exp:Expressao = Operacao.Soma
exp.apply { ->  }

    /*val listaNumero = mutableListOf<Numero>()
    var operador:Operacao? = null
    var expresao:Expressao? = null

    for (l in list) {

        if (l is Operacao) operador = l

        if(expresao ==null) {

            if (l is Numero) listaNumero.add(l)

            if (listaNumero.size == 2) {
                listaNumero.get(0), listaNumero.get(1)

                expresao = operador?.calculo()
            }

        } else {
            if (l is Numero)  expresao = operador?.calculo(expresao, l)
        }
    }
    //expresao = Operacao.Porcentagem.calculo(expresao!!, Numero(10.0))

    println(expresao?.calcula().rem(expresao?.calcula()))*/
}