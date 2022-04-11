package android.example.flowerschemistry.data.api

import android.example.flowerschemistry.data.models.*
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface InterfaceAPI {

    @GET("bouquet")
    suspend fun getBouquetCatalog(): Response<ArrayList<BouquetCatalogItemItem>>

    @GET("bouquet/selection?selection=Рекомендации")
    suspend fun getBouquetRecommendation(): Response<ArrayList<BouquetSelectionItem>>

    @GET("bouquet/selection?selection=Для%20девушки")
    suspend fun getBouquetPopular(): Response<ArrayList<BouquetSelectionItem>>

    @GET("bouquet/selection?selection=Для%20коллеги")
    suspend fun getBouquetDiscount(): Response<ArrayList<BouquetSelectionItem>>

    suspend fun checkUserNumber(number: String): Response<Boolean>

    @FormUrlEncoded
    @POST("client/create")
    suspend fun createUser(
        @Field("phoneNumber") phoneNumber: String,
        @Field("name") name: String
    ): Response<User>

    @FormUrlEncoded
    @POST("auth/login/client")
    suspend fun getToken(
        @Field("phoneNumber") phoneNumber: String,
    ): Response<Token>

    @GET("order/activeOrder")
    suspend fun getActiveOrders(): Response<ArrayList<OrdersItem>>

    @POST("basket")
    suspend fun createBasket(): Response<ArrayList<Basket>>
}