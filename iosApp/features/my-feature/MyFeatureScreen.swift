//
//  MyFeatureScreen.swift
//  iosApp
//
//  Created by Mario Bat on 29.12.2022..
//  Copyright © 2022 orgName. All rights reserved.
//

import SwiftUI
import di
import app
import dashboard

struct MyFeatureScreen : View {
    
    var dashboardViewModel: DashboardViewModel
    
    init<T: AppNavigator>(dashboardNavigator: T){
        dashboardViewModel = DashboardViewModel.companion.create(dashboardNavigator: dashboardNavigator as! DashboardNavigator)
    }
  
    
    var body: some View {
        Text("greet")
    }
}
