package persistence.abstracts;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import persistence.abstracts.Listeners;

public abstract class Lists extends Listeners {
    //region
    protected static final ObservableList<String> yesNoOptions =
            FXCollections.observableArrayList(
                    "Да",
                    "Нет"
            );

    protected static final ObservableList<String> sexOptions =
            FXCollections.observableArrayList(
                    "Мужской",
                    "Женский"
            );

    protected static final ObservableList<String> degreeOptions =
            FXCollections.observableArrayList(
                    "Кандидат наук",
                    "Доктор наук",
                    "Не имею"
            );

    protected static final ObservableList<String> citizenshipOptions =
            FXCollections.observableArrayList(
                    "Российская Федерация",
                    "Другое",
                    "Двойное",
                    "Нет"
            );

    protected static final ObservableList<String> relativesOptions =
            FXCollections.observableArrayList(
                    "Записан первым",
                    "Жена, муж",
                    "Дочь, сын",
                    "Мать, отец",
                    "Сестра, брат",
                    "Свекровь, свекор, теща, тесть",
                    "Невестка (сноха), зять",
                    "Бабушка, дедушка",
                    "Внучка, внук",
                    "Другая степень родства",
                    "Не родственник"
            );

    protected static final ObservableList<String> weddingOptions =
            FXCollections.observableArrayList(
                    "Состою в браке",
                    "Разведен(а) официально (развод зарегистрирован)",
                    "Разошелся(лась)",
                    "Вдовец, вдова",
                    "Никогда не состоял(а) в браке"
            );

    protected static final ObservableList<String> educationOptions =
            FXCollections.observableArrayList(
                    "Начальное общее (начальное)",
                    "Основное общее (неполное среднее)",
                    "Среднее (полное) общее",
                    "Начальное профессиональное",
                    "Среднее профессиональное (среднее специальное)",
                    "Неполное высшее профессиональное (незаконченое высшее)",
                    "Высшее профессиональное (высшее)",
                    "Послевузовское профессиональное",
                    "Не имею образования"
            );

    protected static final ObservableList<String> higherOptions =
            FXCollections.observableArrayList(
                    "Бакалавр",
                    "Специалист",
                    "Магистр"
            );

    protected static final ObservableList<String> positionOptions =
            FXCollections.observableArrayList(
                    "Работающим по найму, договору",
                    "Работающим не по найму с привлечением наемных работников",
                    "Работающим не по найму без привлечения наемных работников",
                    "Иное"
            );

    protected static final ObservableList<String> reasonOptions =
            FXCollections.observableArrayList(
                    "Получил(а) работу и приступаю к ней в ближайшие 2 недели",
                    "Нашел(а) работу и ожидаю ответа",
                    "Ожидаю начала сезона",
                    "Занимаюсь ведением домашнего хозяйства",
                    "Иная причина"
            );

    protected static final ObservableList<String> localityOptions =
            FXCollections.observableArrayList(
                    "Городском",
                    "Сельском"
            );

    protected static final ObservableList<String> migrationOptions =
            FXCollections.observableArrayList(
                    "С рождения",
                    "Переехал(а) в период с ноября 2009 по октябрь 2010",
                    "Переехал в другое время"
            );

    protected static final ObservableList<String> purposeOptions =
            FXCollections.observableArrayList(
                    "Работа",
                    "Учеба",
                    "Служебная или \nделовая поездка",
                    "Лечение",
                    "Туризм, отдых",
                    "Транзитная \nмиграция",
                    "Другая цель"
            );

    protected static final ObservableList<String> buildingTypesOptions =
            FXCollections.observableArrayList(
                    "Индивидуальный (одноквартирный) дом частного жилищного фонда",
                    "Индивидуальный (одноквартирный) дом государственного/муниципального жилищного фонда",
                    "Многоквартирный дом",
                    "Общежитие",
                    "Гостинница",
                    "Другое жилище",
                    "Бездомный"
            );

    protected static final ObservableList<String> foundationOptions =
            FXCollections.observableArrayList(
                    "Ранее 1957",
                    "1957-1970",
                    "1971-1995",
                    "1996-2002",
                    "После 2002"
            );

    protected static final ObservableList<String> materialOptions =
            FXCollections.observableArrayList(
                    "Кирпич, камень",
                    "Панель, блок",
                    "Дерево",
                    "Монолит",
                    "Другой смешанный материал",
                    "Иное"
            );

    protected static final ObservableList<String> gasOptions =
            FXCollections.observableArrayList(
                    "Сетевой",
                    "Сжиженный (баллоны)"
            );

    protected static final ObservableList<String> heatOptions =
            FXCollections.observableArrayList(
                    "Центарльное",
                    "От индивидуальных установок, котлов",
                    "Печное"
            );

    protected static final ObservableList<String> waterOptions =
            FXCollections.observableArrayList(
                    "Водопровод из коммунальной системы",
                    "Водопровод из индивидуальной системы",
                    "Водопровод вне жилища, колонка",
                    "Колодец, скважина или другой источник водоснабжения"
            );

    protected static final ObservableList<String> hotWaterOptions =
            FXCollections.observableArrayList(
                    "Центральное",
                    "От индивидуальных водонагревателей",
                    "Горячее водоснабжение отсутствует"
            );

    protected static final ObservableList<String> canalisationOptions =
            FXCollections.observableArrayList(
                    "Через коммунальную канализационную систему",
                    "Через индивидумальную канализационную систему (включая септик)",
                    "Через систему труб в выгребные ямы и т.п.",
                    "Система канализации отсутствует"
            );

    protected static final ObservableList<String> toiletOptions =
            FXCollections.observableArrayList(
                    "Туалет (со смывом) в жилище",
                    "Туалет другого типа в жилище (включая биотуалет)",
                    "Туалет вне жилища",
                    "Туалет отсутствует"
            );

    protected static final ObservableList<String> bathOptions =
            FXCollections.observableArrayList(
                    "Ванна и (или) душ в жилище",
                    "Ванна и (или) душ вне жилища",
                    "Баня, сауна",
                    "Ванна, душ, баня, сауна отсутствуют"
            );

    protected static final ObservableList<String> garbageOptions =
            FXCollections.observableArrayList(
                    "Мусоропровод",
                    "Мусоросборник вне дома",
                    "Сбор мусора спецмашиной",
                    "Выброс мусора в ямы, на кучи и т.п."
            );

    protected static final ObservableList<String> kitchenOptions =
            FXCollections.observableArrayList(
                    "Кухня или кухонный угол в доме",
                    "Кухня или кухонный угол в отдельном строении",
                    "Кухня и кухонный угол отсутствуют"
            );

    protected static final ObservableList<String> livingPlaceOptions =
            FXCollections.observableArrayList(
                    "Отдельная квартира",
                    "Коммунальная квартира"
            );
    //endregion

    //region Filters
    protected static final ObservableList<String> tablesOptions =
            FXCollections.observableArrayList(
                    "Здания",
                    "Квартиры",
                    "Домохозяйства",
                    "Люди",
                    "Мигранты"
            );
    protected static final ObservableList<String> buildingsOptions =
            FXCollections.observableArrayList(
                    "Тип жилища",
                    "Материал стен"
            );
    protected static final ObservableList<String> flatsOptions =
            FXCollections.observableArrayList(
                    "Площадь",
                    "Кол-во комнат"

            );
    protected static final ObservableList<String> householdsOptions =
            FXCollections.observableArrayList(
                    "Кол-во человек",
                    "Кол-во комнат"
            );
    protected static final ObservableList<String> peopleOptions =
            FXCollections.observableArrayList(
                    "Дата рождения",
                    "Местро рождения",
                    "Гражданство",
                    "Национальность",
                    "Языки",
                    "Родной язык",
                    "Год переезда"
            );
    protected static final ObservableList<String> migratorsOptions =
            FXCollections.observableArrayList(
                    "Год рождения",
                    "Страна проживания",
                    "Страна рождения",
                    "Цель"
            );
    //endregion
}
