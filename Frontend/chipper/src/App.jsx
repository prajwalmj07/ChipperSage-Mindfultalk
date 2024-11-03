import './App.css';
import Cohort_User from './components/Cohort_User';
import SubConcept_Completion from './components/SubConcept_Completion';
import CohortProgress from './components/CohortProgress';
import logo from 'F:/CHIPPER/ChipperSage-Mindfultalk/Frontend/chipper/src/assets/chipper2.png'; // Update the path to your logo

function App() {
  return (
    <>
      <div className="text-center">
        <h1 className="text-4xl font-bold bg-green-100 flex items-center justify-center py-4">
          <img src={logo} alt="Chipper Sage Logo" className="logo h-16" /> {/* Adjust height as needed */}
        </h1>
        <Cohort_User />
        <SubConcept_Completion />
        <CohortProgress />
      </div>
    </>
  );
}

export default App;
