package es.iessaladillo.com.proyecto.model


class EnemyProvider {
    companion object {
        private val EnemyList = listOf(
            Enemy(name = "Luke Skywalker", photo = "https://upload.wikimedia.org/wikipedia/commons/6/67/Luke_Skywalker_-_Welcome_Banner_%28Cropped%29.jpg"),
            Enemy(name = "Darth Vader", photo = "https://upload.wikimedia.org/wikipedia/commons/thumb/3/32/Star_Wars_-_Darth_Vader.jpg/480px-Star_Wars_-_Darth_Vader.jpg"),
            Enemy(name = "Princess Leia", photo = "https://upload.wikimedia.org/wikipedia/en/1/1b/Princess_Leia%27s_characteristic_hairstyle.jpg"),
            Enemy(name = "Han Solo", photo = "https://upload.wikimedia.org/wikipedia/en/b/be/Han_Solo_depicted_in_promotional_image_for_Star_Wars_%281977%29.jpg"),
            Enemy(name = "Obi-Wan Kenobi", photo = "https://upload.wikimedia.org/wikipedia/en/3/32/Ben_Kenobi.png"),
            Enemy(name = "Yoda", photo = "https://upload.wikimedia.org/wikipedia/en/9/9b/Yoda_Empire_Strikes_Back.png"),
            Enemy(name = "Emperor Palpatine", photo = "https://upload.wikimedia.org/wikipedia/en/8/8f/Emperor_RotJ.png"),
            Enemy(name = "Chewbacca", photo = "https://upload.wikimedia.org/wikipedia/commons/thumb/2/2d/Solo-_A_Star_Wars_Story_Japan_Premiere_Red_Carpet-_Chewbacca.jpg/285px-Solo-_A_Star_Wars_Story_Japan_Premiere_Red_Carpet-_Chewbacca.jpg"),
            Enemy(name = "R2-D2", photo = "https://upload.wikimedia.org/wikipedia/en/3/39/R2-D2_Droid.png"),
            Enemy(name = "C-3PO", photo = "https://upload.wikimedia.org/wikipedia/en/5/5c/C-3PO_droid.png"),
            )




        fun filterNameCharacter():ArrayList<String>{
            return EnemyList.map { userCharacter ->
                userCharacter.name
            }.toCollection(ArrayList())
        }

        fun filterPhotoCharacter(): ArrayList<String> {
            return EnemyList.map { userCharacter ->
                userCharacter.photo
            }.toCollection(ArrayList())
        }
        fun getNameAndPhotoUrl(): List<Pair<String, String>> {
            return EnemyList.map { enemy -> enemy.name to enemy.photo }
        }
    }
}