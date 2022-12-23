import SwiftUI
import test
import di

struct ContentView: View {
    let testViewModel = TestViewModelComponent().testViewModel()
    
	var body: some View {
        Text("greet")
	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}
