//
//  MyFeatureScreen.swift
//  iosApp
//
//  Created by Mario Bat on 29.12.2022..
//  Copyright © 2022 orgName. All rights reserved.
//

import SwiftUI
import test

struct MyFeatureScreen : View {
    
    let testViewModel = TestViewModel.companion.create(appComponent: ((UIApplication.shared) as! iOSApp).appComponent as! DiAppComponent)
    
    var body: some View {
        Text("greet")
    }
}
