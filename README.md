# nogle_exam
![exchange_flow_app drawio](https://github.com/ricky7777/nogle_exam/assets/3930480/e1580a6f-4f08-4b91-b80d-7c93234b9c54)
<h1>Use Skill</h1><br/>
1.MVVM<br/>
2.ViewBinding<br/>
3.DataBinding<br/>
4.Coroutine<br/>
5.Livedata<br/>
6.Roomdatabase<br/>
7.Repository pattern<br/>
8.Junit test
<br/><br/>

Cryptocurrency Exchanges<br/>
Please build up App according to the following description<br/>
● Android MVVM architecture (ViewModel/Repository)<br/>
● Use Retrofit + Coroutine to archive HTTP connection<br/>
● Use Navigation Component to handle page direction<br/>
● Use MediatorLiveData to combine multiple data sources<br/>
● Use Kotlin language only<br/>
● Upload source code to Github/GitLab and share signed APK<br/>

Please design UI according to the following description<br/>
- As a user, I want a Single-Activity App with BottomNavigationView that has 4 tabs A, B, C and D<br/>
```diff
+ Implement button on xml
```
● As a user, I want a Single-Activity App with BottomNavigationView that has 4 tabs A, B, C and D<br/>
● I can click tab A to view a market list with name and price on each item and sorted by name<br/>
● I can view spot/futures tabs at top of market list that I can toggle them to see list separately<br/>
● I can view a settings entrance button at top right of D page and click it to go to Settings page<br/>
● I can view the whole Settings page with no BottomNavigationView at the bottom of the screen<br/>
● I can view the page name at the center of the page except A page. So I can know where I am<br/>
<br/><br/>
Data source<br/>
● API path - https://api.btse.com/futures/api/inquire/initial/market<br/>
○ Use parameter symbol to display name<br/>
○ Use parameter future to distinguish between spot and futures<br/>
● WS path - wss://ws.btse.com/ws/futures<br/>
○ Reference https://btsecom.github.io/docs/futures/en/#subscription<br/>
○ Send {"op": "subscribe", "args": ["coinIndex"]} after socket connected<br/>
○ Refer Appendix 1 for response format<br/>
○ Use parameter type = 1 only<br/>
○ Use parameter price to display price<br/>
<br/>
https://www.immigration.gov.tw/media/62712/appendix-1.pdf<br/>
