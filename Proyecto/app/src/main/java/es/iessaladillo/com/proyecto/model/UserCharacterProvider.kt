package es.iessaladillo.com.proyecto.model

class UserCharacterProvider {
    companion object {
        private val userCharacterList = listOf(
            UserCharacter("Ejemplo", "J.4ntonio.28@gmail.com", ),
            UserCharacter("Ejemplo2", "J.4ntonio.28@gmail.com", ),
            UserCharacter("Ejemplo3", "J.4ntonio.28@gmail.com", ),
            UserCharacter("Ejemplo4", "J.4ntonio.28@gmail.com", ),
            UserCharacter("Ejemplo5", "J.4ntonio.29@gmail.com", ),
        )

        fun filterCharactersByEmail(email:String):List<UserCharacter>{
            return userCharacterList.filter { user -> user.email == email }
        }

        fun getCharacters():List<UserCharacter>{
            return userCharacterList
        }
    }
}