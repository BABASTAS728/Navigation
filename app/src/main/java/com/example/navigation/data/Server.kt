package com.example.navigation.data

import com.example.navigation.data.models.FilmResponse
import com.example.navigation.data.models.UiItemResponse
import com.example.navigation.data.models.User
import com.example.navigation.domain.models.UiItem
import kotlinx.coroutines.delay
import java.net.SocketTimeoutException
import javax.inject.Inject

class Server @Inject constructor() {

    companion object {
        var user = User(9, mutableListOf())

        suspend fun getUser(): User {
            return user
        }

        suspend fun getFilmsById(filmsId: List<Int>): List<UiItem.Film> {

            val films: MutableList<UiItem.Film> = mutableListOf()
            for (element in filmsId) {
                when (element) {
                    1 -> films.add(
                        UiItem.Film(
                            "https://kinogo.biz/uploads/mini/minifull/cc2/1672684393-1384154035.webp",
                            "Кот в сапогах",
                            false,
                            7.9,
                            "Классный фильм",
                            1
                        )
                    )
                    2 -> films.add(
                        UiItem.Film(
                            "https://avatars.mds.yandex.net/get-kinopoisk-image/1773646/96d93e3a-fdbf-4b6f-b02d-2fc9c2648a18/600x900",
                            "Титаник",
                            true,
                            9.19,
                            "Очень крутой фильм",
                            2
                        )
                    )
                    3 -> films.add(
                        UiItem.Film(
                            "https://kinogo.biz/uploads/mini/minifull/807/1631897484-1274225097.webp",
                            "Дюна",
                            false,
                            7.7,
                            "Хороший фильм",
                            3
                        )
                    )

                    4 -> films.add(
                        UiItem.Film(
                            "https://kinogo.biz/uploads/mini/minifull/e80/1670614042-1051634032.webp",
                            "Освобождение",
                            false,
                            6.5,
                            "Фильм не очень",
                            4
                        )
                    )

                    5 -> films.add(
                        UiItem.Film(
                            "https://upload.wikimedia.org/wikipedia/ru/5/53/The_Lord_of_the_Rings._The_Return_of_the_King_%E2%80%94_movie.jpg",
                            "Властелин колец 3: Возвращение короля",
                            true,
                            9.45,
                            "Классный фильм",
                            5
                        )
                    )

                    6 -> films.add(
                        UiItem.Film(
                            "https://avatars.mds.yandex.net/get-kinopoisk-image/1600647/9bdc6690-de82-4a8c-a114-aa3a353bc1da/600x900",
                            "Звездные войны: Эпизод 4 - Новая надежда",
                            true,
                            8.68,
                            "Очень классный фильм",
                            6
                        )
                    )

                    7 -> films.add(
                        UiItem.Film(
                            "https://kinogo.biz/uploads/mini/minifull/bb9/1654804309-741390359.webp",
                            "Сердце Пармы",
                            false,
                            6.8, "Плохой фильм",
                            7
                        )
                    )

                    8 -> films.add(
                        UiItem.Film(
                            "https://upload.wikimedia.org/wikipedia/ru/5/5e/Gravity_poster.jpg",
                            "Гравитация",
                            true,
                            7.96,
                            "Не смотрел",
                            8
                        )
                    )

                    9 -> films.add(
                        UiItem.Film(
                            "https://avatars.mds.yandex.net/get-kinopoisk-image/1599028/33474b2a-d670-47c8-9cbe-51291847b6d4/300x450",
                            "Крестный отец 2",
                            true,
                            8.9,
                            "Не смотрел, но вроде норм",
                            9
                        )
                    )

                    else -> films.add(
                        UiItem.Film(
                            "https://kinogo.biz/uploads/mini/minifull/6e7/1670015782-176944213.webp",
                            "Тролль",
                            false,
                            5.8,
                            "Не понравился",
                            10
                        )
                    )
                }
            }
            return films
        }
    }

    suspend fun getResponse(): List<UiItemResponse> {
        delay(2000)
        return listOf(
            UiItemResponse(
                category = "Боевики",
                films = listOf(
                    FilmResponse(
                        "https://kinogo.biz/uploads/mini/minifull/cc2/1672684393-1384154035.webp",
                        "Кот в сапогах",
                        false,
                        7.9,
                        "Классный фильм"
                    ),
                    FilmResponse(
                        "https://avatars.mds.yandex.net/get-kinopoisk-image/1773646/96d93e3a-fdbf-4b6f-b02d-2fc9c2648a18/600x900",
                        "Титаник",
                        true,
                        9.19,
                        "Очень крутой фильм"
                    ),
                    FilmResponse(
                        "https://kinogo.biz/uploads/mini/minifull/807/1631897484-1274225097.webp",
                        "Дюна",
                        false,
                        7.7,
                        "Хороший фильм"
                    )
                )
            ),

            UiItemResponse(
                category = "Комедии",
                films = listOf(
                    FilmResponse(
                        "https://kinogo.biz/uploads/mini/minifull/e80/1670614042-1051634032.webp",
                        "Освобождение",
                        false,
                        6.5,
                        "Фильм не очень"
                    ),
                    FilmResponse(
                        "https://upload.wikimedia.org/wikipedia/ru/5/53/The_Lord_of_the_Rings._The_Return_of_the_King_%E2%80%94_movie.jpg",
                        "Властелин колец 3: Возвращение короля",
                        true,
                        9.45,
                        "Классный фильм"
                    ),
                    FilmResponse(
                        "https://avatars.mds.yandex.net/get-kinopoisk-image/1600647/9bdc6690-de82-4a8c-a114-aa3a353bc1da/600x900",
                        "Звездные войны: Эпизод 4 - Новая надежда",
                        true,
                        8.68,
                        "Очень классный фильм"
                    )
                )
            ),

            UiItemResponse(
                category = "Драмы",
                films = listOf(
                    FilmResponse(
                        "https://kinogo.biz/uploads/mini/minifull/bb9/1654804309-741390359.webp",
                        "Сердце Пармы",
                        false,
                        6.8, "Плохой фильм"
                    ),
                    FilmResponse(
                        "https://upload.wikimedia.org/wikipedia/ru/5/5e/Gravity_poster.jpg",
                        "Гравитация",
                        true,
                        7.96,
                        "Не смотрел"
                    ),
                    FilmResponse(
                        "https://avatars.mds.yandex.net/get-kinopoisk-image/1599028/33474b2a-d670-47c8-9cbe-51291847b6d4/300x450",
                        "Крестный отец 2",
                        true,
                        8.9,
                        "Не смотрел, но вроде норм"
                    ),
                    FilmResponse(
                        "https://kinogo.biz/uploads/mini/minifull/6e7/1670015782-176944213.webp",
                        "Тролль",
                        false,
                        5.8,
                        "Не понравился"
                    )
                )
            )
        )
    }
}