import axios from 'axios';
import { useEffect, useState } from 'react';
import { Bar } from 'react-chartjs-2';
import '../styles/Cohort_User.css';
import '../styles/CohortProgress.css';
import {
  Chart as ChartJS,
  CategoryScale,
  LinearScale,
  BarElement,
  Title,
  Tooltip,
  Legend,
} from 'chart.js';

ChartJS.register(CategoryScale, LinearScale, BarElement, Title, Tooltip, Legend);

const Cohort_User = () => {
  const [studentScores, setStudentScores] = useState([]);
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState(null);

  // Filter and sorting state variables
  const [userId, setUserId] = useState('');
  const [cohortId, setCohortId] = useState(987); // Default cohort ID as in the original code
  const [sortedScores, setSortedScores] = useState([]); // Sorted data to display in the table

  // Fetch data based on filter inputs
  const handleFilter = async () => {
    if (!cohortId) {
      console.error("Cohort ID is required for filtering.");
      return;
    }

    setLoading(true);
    try {
      const response = await axios.get('http://localhost:8080/userCohort/getStudentScoresByCohort', {
        params: {
          cohortId,
          ...(userId && { userId }),
        },
      });
      setStudentScores(response.data);
      setSortedScores(response.data); // Initialize sorted data with fetched data
      setLoading(false);
    } catch (err) {
      setError(err);
      setLoading(false);
    }
  };

  // Sort data by score in ascending order
  const sortScoresAscending = () => {
    const sorted = [...studentScores].sort((a, b) => a[4] - b[4]);
    setSortedScores(sorted);
  };

  // Sort data by score in descending order
  const sortScoresDescending = () => {
    const sorted = [...studentScores].sort((a, b) => b[4] - a[4]);
    setSortedScores(sorted);
  };

  // Extract data for charts
  const cohortDescription = studentScores.length > 0 ? studentScores[0][3] : '';
  const names = studentScores.map((student) => `${student[1]} (ID: ${student[0]})`);
  const scores = studentScores.map((student) => student[4]);

  // Data for the bar chart
  const barData = {
    labels: names,
    datasets: [
      {
        label: 'Scores',
        data: scores,
        backgroundColor: 'rgba(113, 122, 255, 0.8)',
      },
    ],
  };

  // Options for the bar chart
  const barOptions = {
    responsive: true,
    maintainAspectRatio: false,
    plugins: {
      legend: {
        position: 'top',
      },
      title: {
        display: true,
        text: `Cohort: ${cohortDescription}`,
      },
    },
  };

  // Get the specific student data if `userId` is provided
  const filteredStudent = userId
    ? studentScores.find((student) => student[0].toString() === userId)
    : null;

  return (
    <div className='flex items-center justify-center flex-col'>
      <h2 className='text-center my-4'>{cohortDescription}</h2>

      {/* Filter Inputs */}
      <div className="filter-container">
      <label htmlFor="">User ID:</label>
        <input
          type="text"
          placeholder="User ID"
          className='border border-slate-800 rounded-md px-3 py-2 mx-2'
          value={userId}
          onChange={(e) => setUserId(e.target.value)}
        />
        <label htmlFor="">Cohort ID:</label>
        <input
          type="text"
          placeholder="Cohort ID"
          className='border border-slate-800 rounded-md px-3 py-2 mx-2'
          value={cohortId}
          onChange={(e) => setCohortId(e.target.value)}
        />
        <button className="ml-3 bg-[#4CAF50] text-white font-semibold py-2 px-4 border border-transparent rounded hover:bg-[#45a049] transition-colors duration-300" onClick={handleFilter}>Show Progress</button>
        <button className='ml-3 bg-transparent hover:bg-blue-500 text-blue-700 font-semibold hover:text-white py-2 px-4 border border-blue-500 hover:border-transparent rounded' onClick={sortScoresAscending}>Low to High</button>
        <button className='ml-3 bg-transparent hover:bg-blue-500 text-blue-700 font-semibold hover:text-white py-2 px-4 border border-blue-500 hover:border-transparent rounded' onClick={sortScoresDescending}>High to Low</button>
      </div>

      {/* Display loading or error messages */}
      {loading && <div>Loading...</div>}
      {error && <div>Error: {error.message}</div>}

      {/* Bar chart */}
      {!loading && !error && studentScores.length > 0 && (
        <div style={{ width: '400px', height: '500px', margin: '0 auto' }}>
          <Bar data={barData} options={barOptions} />
        </div>
      )}

      {/* Display filtered student details in a table */}
      {filteredStudent && (
        <div className="table-container">
          <h3>Filtered Student Details</h3>
          <table>
            <thead>
              <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Cohort</th>
                <th>Score</th>
              </tr>
            </thead>
            <tbody>
              <tr>
                <td>{filteredStudent[0]}</td>
                <td>{filteredStudent[1]}</td>
                <td>{filteredStudent[3]}</td>
                <td>{filteredStudent[4]}</td>
              </tr>
            </tbody>
          </table>
        </div>
      )}

      {/* Display sorted student scores in a table */}
      <div className="table-container">
        <h3>Student Scores</h3>
        <table>
          <thead>
            <tr>
              <th>ID</th>
              <th>Name</th>
              <th>Cohort</th>
              <th>Score</th>
            </tr>
          </thead>
          <tbody>
            {sortedScores.map((student) => (
              <tr key={student[0]}>
                <td>{student[0]}</td>
                <td>{student[1]}</td>
                <td>{student[3]}</td>
                <td>{student[4]}</td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
};

export default Cohort_User;
