package com.fic.cursoandroid.capapresentacion.Student;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.fic.cursoandroid.R;
import com.fic.cursoandroid.capadatos.Student;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.ViewHolder> {

    public List<Student> studentList;

    public StudentAdapter(List<Student> studentList) {
        this.studentList = studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View studentView =  inflater.inflate(R.layout.row_student,parent,false);

        StudentAdapter.ViewHolder viewHolder = new StudentAdapter.ViewHolder(studentView);

        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Student student = studentList.get(position);

        TextView txtStudentName = holder.studentName;
        txtStudentName.setText(student.getName());

        TextView txtStudentLastName = holder.studentLastName;
        txtStudentLastName.setText(student.getPaternalSurname() + " "+ student.getMaternalSurname());

    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView studentName, studentLastName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            studentName = itemView.findViewById(R.id.txtStudentName);
            studentLastName = itemView.findViewById(R.id.txtStudentLastName);
        }
    }
}
