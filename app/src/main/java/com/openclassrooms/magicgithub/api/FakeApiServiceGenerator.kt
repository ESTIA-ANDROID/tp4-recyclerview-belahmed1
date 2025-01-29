package com.openclassrooms.magicgithub.api

import com.openclassrooms.magicgithub.model.User
import java.util.*

object FakeApiServiceGenerator {

    @JvmField
    var FAKE_USERS = mutableListOf(
        User("001", "Jake", "https://robohash.org/1.png?size=300x300"),
        User("002", "Paul", "https://robohash.org/2.png?size=300x300"),
        User("003", "Phil", "https://robohash.org/3.png?size=300x300"),
        User("004", "Guillaume", "https://robohash.org/4.png?size=300x300"),
        User("005", "Francis", "https://robohash.org/5.png?size=300x300"),
        User("006", "George", "https://robohash.org/6.png?size=300x300"),
        User("007", "Louis", "https://robohash.org/7.png?size=300x300"),
        User("008", "Mateo", "https://robohash.org/8.png?size=300x300"),
        User("009", "April", "https://robohash.org/9.png?size=300x300"),
        User("010", "Louise", "https://robohash.org/10.png?size=300x300"),
        User("011", "Elodie", "https://robohash.org/11.png?size=300x300"),
        User("012", "Helene", "https://robohash.org/12.png?size=300x300"),
        User("013", "Fanny", "https://robohash.org/13.png?size=300x300"),
        User("014", "Laura", "https://robohash.org/14.png?size=300x300"),
        User("015", "Gertrude", "https://robohash.org/15.png?size=300x300"),
        User("016", "Chloé", "https://robohash.org/16.png?size=300x300"),
        User("017", "April", "https://robohash.org/17.png?size=300x300"),
        User("018", "Marie", "https://robohash.org/18.png?size=300x300"),
        User("019", "Henri", "https://robohash.org/19.png?size=300x300"),
        User("020", "Rémi", "https://robohash.org/20.png?size=300x300")
    )

    @JvmField
    var FAKE_USERS_RANDOM = Arrays.asList(
        User("021", "Lea", "https://api.adorable.io/AVATARS/512/21.png"),
        User("022", "Geoffrey", "https://api.adorable.io/AVATARS/512/22.png"),
        User("023", "Simon", "https://api.adorable.io/AVATARS/512/23.png"),
        User("024", "André", "https://api.adorable.io/AVATARS/512/24.png"),
        User("025", "Leopold", "https://api.adorable.io/AVATARS/512/25.png")
    )
}