package com.ronasit.bullshitmeter.data.repository

import com.ronasit.bullshitmeter.data.module.LoginResponse
import com.ronasit.bullshitmeter.data.store.User


interface UserRepository  {
     var user : User?
     var token: String?
}