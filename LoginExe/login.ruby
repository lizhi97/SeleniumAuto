require "rautomation"
window = RAutomation::Window.new(:title => /Windows Security/i, :adapter => :win_32)

if window.exists?
  window.activate
  window.send_keys "administrator"
  window.send_keys :tab
  window.send_keys "Landesk1"
  window.send_keys :enter
elsif
  puts "No Windows Security Window exists"
end