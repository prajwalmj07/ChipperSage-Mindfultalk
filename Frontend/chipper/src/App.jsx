import './App.css'
import Cohort_User from './components/Cohort_User'
import SubConcept_Completion from './components/SubConcept_Completion'
function App() {
  return (
    <>
    <div className="text-center">
      <h1 className="text-4xl font-bold bg-green-700">
      ChipperSage
      </h1>
      <Cohort_User />
      <SubConcept_Completion/>
      </div>
    </>
  )
}

export default App
