package com.perso.flowwportfoliohilt.network.movies

import javax.inject.Inject

class MoviesApiHelperImpl @Inject constructor(
    val moviesApiService: MoviesApiService
): MoviesApiHelper {
}