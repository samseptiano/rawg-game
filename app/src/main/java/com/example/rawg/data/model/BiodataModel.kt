package com.example.rawg.data.model

data class UserDataModel(
    var biodataModel: BiodataModel,
    var nationalIDModel: NationalIDModel
)
data class BiodataModel(
    var nationalID: String,
    var fullName: String?,
    var bankAccount: String,
    var education: String,
    var dob: String,
)

data class NationalIDModel(
    var address: String,
    var housingType: String,
    var phoneNumber: String,
    var province: ProvinceResponseItem
)
