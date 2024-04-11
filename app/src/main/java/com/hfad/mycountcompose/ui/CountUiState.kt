package com.hfad.mycountcompose.ui

import com.hfad.mycountcompose.data.Constanta

data class CountUiState(
    val count: Int = 0,
    val step: Int = 1
)

//
//data class ConstantaDetails(
//    val id: Int = 0,
//    val count: Int = 0,
//    val step: Int = 0
//)
//
//fun ConstantaDetails.toConstanta(): Constanta = Constanta(
//    id = id,
//    count = count,
//    step = step
//)
//
//fun Constanta.toCountUiState(isEntryValid: Boolean = false): CountUiState = CountUiState(
//    constantaDetails = this.toConstantaDetails(),
//    isEntryValid = isEntryValid
//)
//
//fun Constanta.toConstantaDetails(): ConstantaDetails = ConstantaDetails(
//    id = id,
//    count = count,
//    step = step
//)