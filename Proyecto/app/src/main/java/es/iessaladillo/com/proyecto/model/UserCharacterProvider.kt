package es.iessaladillo.com.proyecto.model

class UserCharacterProvider {
    companion object {
        private val userCharacterList = listOf(
            UserCharacter("Ejemplo", "J.4ntonio.28@gmail.com" ),
            UserCharacter("Ejemplo2", "J.4ntonio.28@gmail.com" ),
            UserCharacter("Ejemplo3", "J.4ntonio.28@gmail.com" ),
            UserCharacter("Ejemplo4", "J.4ntonio.28@gmail.com" ),
            UserCharacter("Ejemplo5", "J.4ntonio.29@gmail.com" ),
            UserCharacter(name = "Luke Skywalker", photo = "https://upload.wikimedia.org/wikipedia/commons/6/67/Luke_Skywalker_-_Welcome_Banner_%28Cropped%29.jpg"),
            UserCharacter(name = "Darth Vader", photo = "https://upload.wikimedia.org/wikipedia/commons/thumb/3/32/Star_Wars_-_Darth_Vader.jpg/480px-Star_Wars_-_Darth_Vader.jpg"),
            UserCharacter(name = "Princess Leia", photo = "https://upload.wikimedia.org/wikipedia/en/1/1b/Princess_Leia%27s_characteristic_hairstyle.jpg"),
            UserCharacter(name = "Han Solo", photo = "https://upload.wikimedia.org/wikipedia/en/b/be/Han_Solo_depicted_in_promotional_image_for_Star_Wars_%281977%29.jpg"),
            UserCharacter(name = "Obi-Wan Kenobi", photo = "https://upload.wikimedia.org/wikipedia/en/3/32/Ben_Kenobi.png"),
            UserCharacter(name = "Yoda", photo = "https://upload.wikimedia.org/wikipedia/en/9/9b/Yoda_Empire_Strikes_Back.png"),
            UserCharacter(name = "Emperor Palpatine", photo = "https://upload.wikimedia.org/wikipedia/en/8/8f/Emperor_RotJ.png"),
            UserCharacter(name = "Chewbacca", photo = "https://upload.wikimedia.org/wikipedia/commons/thumb/2/2d/Solo-_A_Star_Wars_Story_Japan_Premiere_Red_Carpet-_Chewbacca.jpg/285px-Solo-_A_Star_Wars_Story_Japan_Premiere_Red_Carpet-_Chewbacca.jpg"),
            UserCharacter(name = "R2-D2", photo = "https://upload.wikimedia.org/wikipedia/en/3/39/R2-D2_Droid.png"),
            UserCharacter(name = "C-3PO", photo = "https://upload.wikimedia.org/wikipedia/en/5/5c/C-3PO_droid.png")

        )

        fun filterCharactersByEmail(email:String):List<UserCharacter>{
            return userCharacterList.filter { user -> user.email == email }
        }

        fun getCharacters():List<UserCharacter>{
            return userCharacterList
        }

        fun filterCharactersWithoutEmail():List<UserCharacter>{
            return userCharacterList.filter { user -> user.email == null }
        }

        fun filterNameCharacterWithoutEmail():ArrayList<String>{
            return userCharacterList.filter { userCharacter ->
                userCharacter.email.isNullOrEmpty()
            }.map { userCharacter ->
                userCharacter.name
            }.toCollection(ArrayList())
        }

        fun filterPhotoCharacterWithoutEmail(): ArrayList<String?> {
            return userCharacterList.filter { userCharacter ->
                userCharacter.email.isNullOrEmpty()
            }.map { userCharacter ->
                userCharacter.photo
            }.toCollection(ArrayList())
        }
    }
}