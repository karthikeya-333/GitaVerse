
<h1>📖 GitaVerse</h1>
<p>GitaVerse is a Spring Boot application that sends <strong>one Bhagavad Gita shloka to my email every day</strong>.</p>
<p>The application is executed <strong>daily using GitHub Actions</strong>, which runs the Spring Boot app and automatically sends the email.</p>
<hr/>
<h2>🛠️ Tech Stack</h2>
<ul>
<li>Spring Boot</li>
<li>PostgreSQL</li>
<li>Spring Data JPA</li>
<li>Spring Mail (SMTP)</li>
<li>GitHub Actions (Cron-based scheduler)</li>
</ul>
<hr/>
<h2>⚙️ How It Works</h2>
<ol>
<li>Bhagavad Gita shlokas are stored in a PostgreSQL database</li>
<li>A GitHub Actions workflow runs every day</li>
<li>The workflow starts the Spring Boot application</li>
<li>The application fetches a shloka from the database</li>
<li>The shloka is sent to my email via SMTP</li>
</ol>
<hr/>
<h2>🚀 Run Locally</h2>
<h3>Clone the Repository</h3>
<pre><code>git clone https://github.com/karthikeya-333/GitaVerse.git
cd GitaVerse</code></pre>
<h3>Configure Environment Variables</h3>
<p>Set database and email credentials in <code>application.yml</code> or using environment variables.</p>
<h3>Run the Application</h3>
<pre><code>mvn spring-boot:run</code></pre>
<hr/>
<h2>⏰ GitHub Actions</h2>
<ul>
<li>The application is triggered daily using a cron-based workflow</li>
<li>Sensitive values are stored securely using GitHub Secrets</li>
</ul>
<hr/>
<h2>👤 Author</h2>
<p><strong>Karthikeya Chanda</strong></p>

