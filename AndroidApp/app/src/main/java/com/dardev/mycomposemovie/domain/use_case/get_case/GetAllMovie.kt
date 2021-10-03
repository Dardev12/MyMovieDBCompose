package com.dardev.mycomposemovie.domain.use_case.get_case

import com.dardev.mycomposemovie.common.Resources
import com.dardev.mycomposemovie.data.remote.dto.toMovieReponse
import com.dardev.mycomposemovie.domain.model.MovieReponse
import com.dardev.mycomposemovie.domain.repository.IComposeMovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

class GetAllMovie @Inject constructor(
    private val repository: IComposeMovieRepository
) {
    operator fun invoke():Flow<Resources<MovieReponse>> = flow {
        try {
            emit(Resources.Loading<MovieReponse>())
            val movies = repository.getAllMovie().toMovieReponse()
            emit(Resources.Success<MovieReponse>(movies))
        }catch (e:HttpException){
            emit(Resources.Error<MovieReponse>(e.localizedMessage ?: "Une erreur inattendue est apparue"))
        }catch (e:IOException){
            emit(Resources.Error<MovieReponse>("N'arrive pas à communiquer avec le serveur. Vérifier votre connexion"))
        }
    }

}