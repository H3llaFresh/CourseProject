package com.example.courseproject.model.service

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface ServiceDao {

    @Query("SELECT * FROM Service")
    fun selectAllServices(): Flow<List<ServiceEntity>>

    @Query("SELECT * FROM Service WHERE serviceID = :serviceID")
    suspend fun selectService(serviceID: Int): ServiceEntity

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertService(service: ServiceEntity)

    @Update
    suspend fun updateService(service: ServiceEntity)

    @Delete
    suspend fun deleteService(service: ServiceEntity)
}