import axios from 'axios';
import { useEffect, useState } from 'react';
import { Bar } from 'react-chartjs-2';
import {
  Chart as ChartJS,
  CategoryScale,
  LinearScale,
  BarElement,
  Title,
  Tooltip,
  Legend,
} from 'chart.js';

ChartJS.register(
  CategoryScale,
  LinearScale,
  BarElement,
  Title,
  Tooltip,
  Legend
);

const CohortProgress = () => {
  const [progressData, setProgressData] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  // Filter state variables
  const [userId, setUserId] = useState('');
  const [programId, setProgramId] = useState(3); // Default program ID

  // Fetch data based on filter inputs
  const fetchCohortProgress = async () => {
    try {
      const response = await axios.get(
        'http://localhost:8080/userCohort/getCohortProgressByProgram',
        {
          params: {
            programId,
            ...(userId && { userId }), // Include userId if it's provided
          },
        }
      );
      setProgressData(response.data);
      setLoading(false);
    } catch (err) {
      setError(err);
      setLoading(false);
    }
  };

  // Effect to fetch data on initial load or programId change
  useEffect(() => {
    fetchCohortProgress();
  }, [programId]);

  // Fetch data when userId changes
  useEffect(() => {
    if (userId) {
      fetchCohortProgress();
    }
  }, [userId]);

  if (loading) return <div>Loading...</div>;
  if (error) return <div>Error: {error.message}</div>;

  // Extract data for charts
  const cohortName = progressData.length > 0 ? progressData[0][0] : '';
  const names = progressData.map((user) => `${user[2]} (ID: ${user[1]})`);
  const progressPercentages = progressData.map((user) =>
    user[6] === 'Active' ? user[5] : 20 // 20% height if inactive
  );
  const statusColors = progressData.map((user) =>
    user[6] === 'Active' ? 'rgba(75, 192, 192, 0.8)' : 'rgba(255, 99, 132, 0.8)'
  );
  const labels = progressData.map((user) =>
    user[6] === 'Active' ? `${user[2]}` : 'User Inactive'
  );

  // Data for the bar chart
  const barData = {
    labels: names,
    datasets: [
      {
        label: 'Completion Progress (%)',
        data: progressPercentages,
        backgroundColor: statusColors,
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
        text: `Cohort Completion and Status: ${cohortName}`,
      },
      tooltip: {
        callbacks: {
          label: function (context) {
            const label = labels[context.dataIndex];
            const percentage = progressPercentages[context.dataIndex];
            const status = progressData[context.dataIndex][6];
            return `${label}: ${percentage}% (${status})`;
          },
        },
      },
    },
  };

  return (
    <div className='flex items-center justify-center flex-col'>
      <h2 className='text-center my-4'>{cohortName} - Completion Progress and Status</h2>

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
        <label htmlFor="">Program ID:</label>
        <input
          type="text"
          placeholder="Program ID"
          className='border border-slate-800 rounded-md px-3 py-2 mx-2'
          value={programId}
          onChange={(e) => setProgramId(e.target.value)}
        />
        <button onClick={fetchCohortProgress}>Show Progress</button>
      </div>

      {/* Bar chart */}
      <div style={{ width: '400px', height: '500px', margin: '0 auto' }}>
        <Bar data={barData} options={barOptions} />
      </div>
    </div>
  );
};

export default CohortProgress;
