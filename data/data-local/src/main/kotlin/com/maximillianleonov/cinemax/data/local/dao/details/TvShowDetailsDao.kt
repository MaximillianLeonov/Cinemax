/*
 * Copyright 2022 Maximillian Leonov
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.maximillianleonov.cinemax.data.local.dao.details

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.maximillianleonov.cinemax.core.data.util.Constants.Tables.TV_SHOW_DETAILS
import com.maximillianleonov.cinemax.data.local.entity.details.TvShowDetailsEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface TvShowDetailsDao {
    @Query("SELECT * FROM $TV_SHOW_DETAILS WHERE id = :id")
    fun getById(id: Int): Flow<TvShowDetailsEntity?>

    @Query("SELECT * FROM $TV_SHOW_DETAILS WHERE id IN (:ids)")
    fun getByIds(ids: List<Int>): Flow<List<TvShowDetailsEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(entity: TvShowDetailsEntity)

    @Query("DELETE FROM $TV_SHOW_DETAILS WHERE id = :id")
    suspend fun deleteById(id: Int)

    @Query("DELETE FROM $TV_SHOW_DETAILS")
    suspend fun deleteAll()
}