package com.example.mobile_pfe.sevices;

import com.example.mobile_pfe.Model.Equipe.EquipeList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface EquipeService {
    @GET("/equipes")
    Call<EquipeList> getAll();

}
