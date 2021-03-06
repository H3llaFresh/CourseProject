package com.example.courseproject

import com.example.courseproject.model.HotelRoomDatabase
import com.example.courseproject.model.guest.GuestEntity
import com.example.courseproject.model.login.LoginEntity
import com.example.courseproject.model.meal.MealEntity
import com.example.courseproject.model.number.NumberEntity
import com.example.courseproject.model.service.ServiceEntity
import kotlinx.coroutines.flow.Flow
import java.text.SimpleDateFormat
import java.util.*

class HotelRepository(hotelDatabase: HotelRoomDatabase) {

    private val loginDao = hotelDatabase.loginDao()
    private val guestDao = hotelDatabase.guestDao()
    private val mealDao = hotelDatabase.mealDao()
    private val serviceDao = hotelDatabase.serviceDao()
    private val numberDao = hotelDatabase.numberDao()
    private val todayDate = SimpleDateFormat("dd.MM.yyyy", Locale.US)
        .format(Calendar.getInstance().time)

    var guests: Flow<List<GuestEntity>>? = null

    var meals: Flow<List<MealEntity>>? = null

    var services: Flow<List<ServiceEntity>>? = null

    fun getUserLoginData(inputLogin: String): LoginEntity {
        return loginDao.getUserLogin(inputLogin)
    }

    suspend fun insertLogin(newLogin: LoginEntity) {
        loginDao.insertLogin(newLogin)
    }

    suspend fun selectGuest(guestID: Int): GuestEntity {
        return guestDao.selectGuest(guestID)
    }

    suspend fun selectMeal(mealID: Int): MealEntity {
        return mealDao.selectMeal(mealID)
    }

    suspend fun selectService(serviceID: Int): ServiceEntity {
        return serviceDao.selectService(serviceID)
    }

    suspend fun selectHotelNumber(numberID: Int): NumberEntity {
        return numberDao.selectHotelNumber(numberID)
    }

    fun refreshGuests() {
        guests = guestDao.selectAllGuests()
    }

    fun refreshMeals() {
        meals = mealDao.selectAllMeals()
    }

    fun refreshTodayMeals() {
        meals = mealDao.selectAllTodayMeals(todayDate)
    }

    fun refreshServices() {
        services = serviceDao.selectAllServices()
    }

    suspend fun addGuest(guest: GuestEntity) {
        guestDao.insertGuest(guest)
    }

    suspend fun addMeal(meal: MealEntity) {
        mealDao.insertMeal(meal)
    }

    suspend fun addService(service: ServiceEntity) {
        serviceDao.insertService(service)
    }

    suspend fun deleteGuest(guest: GuestEntity) {
        guestDao.deleteGuest(guest)
    }

    suspend fun deleteMeal(meal: MealEntity) {
        mealDao.deleteMeal(meal)
    }

    suspend fun deleteService(service: ServiceEntity)  {
        serviceDao.deleteService(service)
    }

    suspend fun updateGuest(guest: GuestEntity) {
        guestDao.updateGuest(guest)
    }

    suspend fun updateMeal(meal: MealEntity) {
        mealDao.updateMeal(meal)
    }

    suspend fun updateService(service: ServiceEntity) {
        serviceDao.updateService(service)
    }

    suspend fun updateLogin(newLogin: LoginEntity) {
        loginDao.updateLogin(newLogin)
    }

    suspend fun orderMeal(mealID: Int, guestID: Int) {
        guestDao.orderMeal(mealID, guestID)
    }

    suspend fun orderService(serviceID: Int, guestID: Int) {
        guestDao.orderService(serviceID, guestID)
    }
}