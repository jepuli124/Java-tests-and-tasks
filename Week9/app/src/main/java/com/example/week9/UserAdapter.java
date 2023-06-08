package com.example.week9;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserView> {
    private Context context;
    private ArrayList<User> users = new ArrayList<User>();

    public UserAdapter(Context context, ArrayList<User> users) {
        this.context = context;
        this.users = users;
    }

    @NonNull
    @Override
    public UserView onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        return new UserView(LayoutInflater.from(context).inflate(R.layout.activity_list_part, parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull UserView holder, int position){
        String degrees = "Tutkinnot:";
        holder.txtName.setText(users.get(position).getFirstname()+ " "+ users.get(position).getLastname());
        holder.txtProfession.setText(users.get(position).getDegreeProgram());
        holder.txtEmail.setText(users.get(position).getEmail());
        holder.profile.setImageResource(users.get(position).getImage());
        for (String degree : users.get(position).getDegrees()){
            degrees = degrees.concat("\n" + degree);
        }
        holder.txtDegrees.setText(degrees);
    }

    @Override
    public int getItemCount(){
        return users.size();
    }


}
