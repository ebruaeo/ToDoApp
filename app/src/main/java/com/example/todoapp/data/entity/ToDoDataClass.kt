package com.example.todoapp.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull
import java.io.Serializable

@Entity(tableName = "todos")
data class ToDoDataClass(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "task_id") @NotNull var task_id: Int,
    @ColumnInfo(name = "task_time") @NotNull var task_time: String,
    @ColumnInfo(name = "task_name") @NotNull var task_name: String
) : Serializable {
}