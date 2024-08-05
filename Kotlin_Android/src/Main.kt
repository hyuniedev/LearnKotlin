fun main() {
    repeat(100){ times ->
        println("${times+1}. I'm sorry bae <3")
    }
    
}
//fun Event.durationOfEvent(): String{
//    if (this.durationInMinutes < 60) {
//        return "short"
//    } else {
//        return "long"
//    }
//}

val Event.durationOfEvent : String
    get() = if(this.durationInMinutes < 60){
        "short"
    }else{
        "long"
    }

data class Event(
    val title: String,
    val description: String? = null,
    val daypart: Daypart,
    val durationInMinutes: Int,
)
enum class Daypart {
    MORNING,
    AFTERNOON,
    EVENING,
}

sealed class Person{
    class Human()
    class Dog()
    class Cat()
}