package com.ronasit.bullshitmeter.data.store

import android.content.Context
import androidx.datastore.preferences.createDataStore
import androidx.datastore.preferences.edit
import androidx.datastore.preferences.preferencesKey
import androidx.datastore.preferences.remove
import com.google.gson.Gson
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking

class PreferencesImpl(
    private val context: Context,
    private val gson: Gson
) : Preferences {

    private enum class Fields(name: String) {
        USER("user"),
        TOKEN("token"),
        LANGUAGE("language")
    }

    private val dataStore = context.createDataStore(name = "preference_user")
    override var user: User?
        get() {
            return runBlocking {
                dataStore.data.first()[preferencesKey<String>(Fields.USER.name)]?.let {
                    gson.fromJson(it, User::class.java)
                } ?: run { null }
            }
        }
        set(value) {
            runBlocking {
                dataStore.edit { preferences ->
                    value?.let { safeUser ->
                        preferences[preferencesKey(Fields.USER.name)] = gson.toJson(safeUser)
                    } ?: run { preferences.remove(preferencesKey(Fields.USER.name)) }
                }
            }
        }

    override var token: String?
        get() {
            return runBlocking {
                dataStore.data.first()[preferencesKey(Fields.TOKEN.name)]
            }
        }
        set(value) {
            runBlocking {
                dataStore.edit { preferences ->
                    value?.let {
                        preferences[preferencesKey(Fields.TOKEN.name)] = it
                    } ?: run {
                        preferences.remove(preferencesKey(Fields.TOKEN.name))
                    }
                }
            }
        }

    override var language: Languages?
        get() {
            return runBlocking {
                dataStore.data.first()[preferencesKey<String>(Fields.LANGUAGE.name)]?.let {
                    gson.fromJson(it, Languages::class.java)
                } ?: run { null }
            }
        }
        set(value) {
            runBlocking {
                dataStore.edit { preferences ->
                    value?.let {
                        preferences[preferencesKey(Fields.LANGUAGE.name)] = gson.toJson(it)
                    } ?: run {
                        preferences.remove(preferencesKey(Fields.LANGUAGE.name))
                    }
                }
            }
        }
}