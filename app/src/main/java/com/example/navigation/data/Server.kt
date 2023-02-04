package com.example.navigation.data

import com.example.navigation.data.models.UiItemResponse
import javax.inject.Inject

class Server @Inject constructor() {
    fun getResponse(): List<UiItemResponse> =
        listOf(
            UiItemResponse.Header("Боевики"),
            UiItemResponse.Film(
                "https://kinogo.biz/uploads/mini/minifull/cc2/1672684393-1384154035.webp",
                "Кот в сапогах",
                false,
                7.9,
                "Классный фильм"
            ),
            UiItemResponse.Film(
                "https://avatars.mds.yandex.net/get-kinopoisk-image/1773646/96d93e3a-fdbf-4b6f-b02d-2fc9c2648a18/600x900",
                "Титаник",
                true,
                9.19,
                "Очень крутой фильм"
            ),
            UiItemResponse.Film(
                "https://kinogo.biz/uploads/mini/minifull/807/1631897484-1274225097.webp",
                "Дюна",
                false,
                7.7,
                "Хороший фильм"
            ),
            UiItemResponse.Header("Комедии"),
            UiItemResponse.Film(
                "https://kinogo.biz/uploads/mini/minifull/e80/1670614042-1051634032.webp",
                "Освобождение",
                false,
                6.5,
                "Фильм не очень"
            ),
            UiItemResponse.Film(
                "https://upload.wikimedia.org/wikipedia/ru/5/53/The_Lord_of_the_Rings._The_Return_of_the_King_%E2%80%94_movie.jpg",
                "Властелин колец 3: Возвращение короля",
                true,
                9.45,
                "Классный фильм"
            ),
            UiItemResponse.Film(
                "https://avatars.mds.yandex.net/get-kinopoisk-image/1600647/9bdc6690-de82-4a8c-a114-aa3a353bc1da/600x900",
                "Звездные войны: Эпизод 4 - Новая надежда",
                true,
                8.68,
                "Очень классный фильм"
            ),
            UiItemResponse.Header("Драмы"),
            UiItemResponse.Film(
                "https://kinogo.biz/uploads/mini/minifull/bb9/1654804309-741390359.webp",
                "Сердце Пармы",
                false,
                6.8, "Плохой фильм"
            ),
            UiItemResponse.Film(
                "https://upload.wikimedia.org/wikipedia/ru/5/5e/Gravity_poster.jpg",
                "Гравитация",
                true,
                7.96,
                "Не смотрел"
            ),
            UiItemResponse.Film(
                "https://avatars.mds.yandex.net/get-kinopoisk-image/1599028/33474b2a-d670-47c8-9cbe-51291847b6d4/300x450",
                "Крестный отец 2",
                true,
                8.9,
                "Не смотрел, но вроде норм"
            ),
            UiItemResponse.Film(
                "https://kinogo.biz/uploads/mini/minifull/6e7/1670015782-176944213.webp",
                "Тролль",
                false,
                5.8,
                "Не понравился"
            )
        )
}