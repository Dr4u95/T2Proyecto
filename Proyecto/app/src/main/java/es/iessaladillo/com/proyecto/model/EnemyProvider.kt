package es.iessaladillo.com.proyecto.model


class EnemyProvider {
    companion object {
        private val EnemyList = listOf(
            Enemy(
                name = "Luke Skywalker",
                photo = "https://upload.wikimedia.org/wikipedia/commons/6/67/Luke_Skywalker_-_Welcome_Banner_%28Cropped%29.jpg"
            ),
            Enemy(
                name = "Darth Vader",
                photo = "https://upload.wikimedia.org/wikipedia/commons/thumb/3/32/Star_Wars_-_Darth_Vader.jpg/480px-Star_Wars_-_Darth_Vader.jpg"
            ),
            Enemy(
                name = "Princess Leia",
                photo = "https://upload.wikimedia.org/wikipedia/en/1/1b/Princess_Leia%27s_characteristic_hairstyle.jpg"
            ),
            Enemy(
                name = "Han Solo",
                photo = "https://upload.wikimedia.org/wikipedia/en/b/be/Han_Solo_depicted_in_promotional_image_for_Star_Wars_%281977%29.jpg"
            ),
            Enemy(
                name = "Obi-Wan Kenobi",
                photo = "https://upload.wikimedia.org/wikipedia/en/3/32/Ben_Kenobi.png"
            ),
            Enemy(
                name = "Yoda",
                photo = "https://upload.wikimedia.org/wikipedia/en/9/9b/Yoda_Empire_Strikes_Back.png"
            ),
            Enemy(
                name = "Emperor Palpatine",
                photo = "https://upload.wikimedia.org/wikipedia/en/8/8f/Emperor_RotJ.png"
            ),
            Enemy(
                name = "Chewbacca",
                photo = "https://upload.wikimedia.org/wikipedia/commons/thumb/2/2d/Solo-_A_Star_Wars_Story_Japan_Premiere_Red_Carpet-_Chewbacca.jpg/285px-Solo-_A_Star_Wars_Story_Japan_Premiere_Red_Carpet-_Chewbacca.jpg"
            ),
            Enemy(
                name = "R2-D2",
                photo = "https://upload.wikimedia.org/wikipedia/en/3/39/R2-D2_Droid.png"
            ),
            Enemy(
                name = "C-3PO",
                photo = "https://upload.wikimedia.org/wikipedia/en/5/5c/C-3PO_droid.png"
            ),

            Enemy(
                name = "Boba Fett",
                photo = "https://upload.wikimedia.org/wikipedia/commons/thumb/7/70/DJA_7971_%289359695765%29.jpg/480px-DJA_7971_%289359695765%29.jpg"
            ),
            Enemy(
                name = "Darth Maul",
                photo = "https://upload.wikimedia.org/wikipedia/commons/thumb/8/86/Darth_Maul_Cosplayer_at_MCM_Comic_Con_October_2016.jpg/285px-Darth_Maul_Cosplayer_at_MCM_Comic_Con_October_2016.jpg"
            ),
            Enemy(
                name = "Kylo Ren",
                photo = "https://upload.wikimedia.org/wikipedia/commons/thumb/f/f2/Kylo_Ren_C2E2_2016_%2825840502132%29.jpg/480px-Kylo_Ren_C2E2_2016_%2825840502132%29.jpg"
            ),
            Enemy(
                name = "Count Dooku",
                photo = "data:image/jpeg;base64,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"
            ),
        )

        fun getNameAndPhotoUrl(): List<Pair<String, String>> {
            return EnemyList.map { enemy -> enemy.name to enemy.photo }
        }
    }
}