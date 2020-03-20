# MVVM-Sample
This is a sample app of using mvvm pattern in kotlin.


## Add the below dependencies in your app level build.gradle file
```
implementation "android.arch.lifecycle:extensions:1.1.1"
annotationProcessor "android.arch.lifecycle:compiler:1.1.1"
```

## Create a Repository class where we fetch data from API or DB
```
object UserRepository {

    fun getMutableLiveData(context: Context) : MutableLiveData<ArrayList<User>>{

        val mutableLiveData = MutableLiveData<ArrayList<User>>()

        context.showProgressBar()

        ApiClient.apiService.getUsers().enqueue(object : Callback<MutableList<User>> {
            override fun onFailure(call: Call<MutableList<User>>, t: Throwable) {
                hideProgressBar()
                Log.e("error", t.localizedMessage)
            }

            override fun onResponse(
                call: Call<MutableList<User>>,
                response: Response<MutableList<User>>
            ) {
                hideProgressBar()
                val usersResponse = response.body()
                usersResponse?.let { mutableLiveData.value = it as ArrayList<User> }
            }

        })

        return mutableLiveData
    }

}
```

## Create a ViewModel class to handle data
```
class UserViewModel(private val context: Context) : ViewModel() {

    private var listData = MutableLiveData<ArrayList<User>>()

    init{
        val userRepository : UserRepository by lazy {
            UserRepository
        }
        if(context.isInternetAvailable()) {
            listData = userRepository.getMutableLiveData(context)
        }
    }

    fun getData() : MutableLiveData<ArrayList<User>>{
        return listData
    }

}
```

## Create a ViewModelFactory class to pass custom arguments with ViewModel
```
class UserViewModelFactory(private val context: Context) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return UserViewModel(context) as T
    }

}
```

## Usage
```
val userViewModel = ViewModelProviders.of(this,UserViewModelFactory(this)).get(UserViewModel::class.java)
userViewModel.getData().observe(this,object:Observer<ArrayList<User>>{
     override fun onChanged(t: ArrayList<User>?) {
          listUsers.clear()
          t?.let { listUsers.addAll(it) }
          adapter.notifyDataSetChanged()
        }

     })
```        
