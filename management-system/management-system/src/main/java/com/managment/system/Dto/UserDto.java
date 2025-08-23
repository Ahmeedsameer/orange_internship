    package com.managment.system.Dto;

    import com.managment.system.entites.Task;
    import com.managment.system.entites.User;


    import java.util.ArrayList;
    import java.util.List;

    public class UserDto {
        private long id;
        private String user_type;
        private String username;
        List<TaskDto>taskList=new ArrayList<>();
        public static UserDto userDto(User user){
            if (user==null){
                return null;
            }
            UserDto userDto=new UserDto();
            userDto.setUsername(user.getUsername());
            userDto.setUser_type(user.getUser_type());
            userDto.setId(user.getId());
            userDto.setTaskList(TaskDto.toDtoList(user.getList()));
            return userDto;
        }

        public static User toEntity(UserDto userDto){
            if(userDto==null){
                return null;
            }
            User user=new User();
            user.setId(userDto.getId());
            user.setUsername(userDto.getUsername());
            user.setUser_type(userDto.getUser_type());
            return user;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getUser_type() {
            return user_type;
        }

        public void setUser_type(String user_type) {
            this.user_type = user_type;
        }

        public List<TaskDto> getTaskList() {
            return taskList;
        }

        public void setTaskList(List<TaskDto> taskList) {
            this.taskList = taskList;
        }
    }
